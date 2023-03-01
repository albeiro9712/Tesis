package com.unicauca.tesis.api.mappers;

import com.unicauca.tesis.api.models.DTO.request.BaseDatos;
import com.unicauca.tesis.api.models.DTO.request.CaracteristicasTecnicas;
import com.unicauca.tesis.api.models.DTO.request.Costo;
import com.unicauca.tesis.api.models.DTO.request.Documentacion;
import com.unicauca.tesis.api.models.DTO.request.FuncionalidadesBD;
import com.unicauca.tesis.api.models.entities.CaracteristicasSGBD;
import com.unicauca.tesis.api.models.entities.Herramienta;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-28T23:18:04-0500",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.5 (Eclipse Adoptium)"
)
public class ResponseBDMapperImpl implements ResponseBDMapper {

    @Override
    public BaseDatos convertCaracteristicasSGBDEntityABaseDatos(CaracteristicasSGBD caracteristicasSGBD) {
        if ( caracteristicasSGBD == null ) {
            return null;
        }

        BaseDatos baseDatos = new BaseDatos();

        baseDatos.setCosto( caracteristicasSGBDToCosto( caracteristicasSGBD ) );
        baseDatos.setDocumentacion( caracteristicasSGBDToDocumentacion( caracteristicasSGBD ) );
        baseDatos.setFuncionalidadesBD( caracteristicasSGBDToFuncionalidadesBD( caracteristicasSGBD ) );
        baseDatos.setCaracteristicasTecnicas( caracteristicasSGBDToCaracteristicasTecnicas( caracteristicasSGBD ) );
        baseDatos.setNombre( caracteristicasSGBDHerramientaNombre( caracteristicasSGBD ) );

        return baseDatos;
    }

    protected Costo caracteristicasSGBDToCosto(CaracteristicasSGBD caracteristicasSGBD) {
        if ( caracteristicasSGBD == null ) {
            return null;
        }

        Costo costo = new Costo();

        costo.setValor( caracteristicasSGBD.getCosto() );

        return costo;
    }

    protected Documentacion caracteristicasSGBDToDocumentacion(CaracteristicasSGBD caracteristicasSGBD) {
        if ( caracteristicasSGBD == null ) {
            return null;
        }

        Documentacion documentacion = new Documentacion();

        documentacion.setValor( caracteristicasSGBD.getDocumentacion() );

        return documentacion;
    }

    protected FuncionalidadesBD caracteristicasSGBDToFuncionalidadesBD(CaracteristicasSGBD caracteristicasSGBD) {
        if ( caracteristicasSGBD == null ) {
            return null;
        }

        FuncionalidadesBD funcionalidadesBD = new FuncionalidadesBD();

        funcionalidadesBD.setApisMetodosAcceso( caracteristicasSGBD.getApisMetodosAcceso() );
        funcionalidadesBD.setMetodosReplicacion( caracteristicasSGBD.getMetodosReplicacion() );
        funcionalidadesBD.setFuncionesCifrado( caracteristicasSGBD.getFuncionesCifrado() );

        return funcionalidadesBD;
    }

    protected CaracteristicasTecnicas caracteristicasSGBDToCaracteristicasTecnicas(CaracteristicasSGBD caracteristicasSGBD) {
        if ( caracteristicasSGBD == null ) {
            return null;
        }

        CaracteristicasTecnicas caracteristicasTecnicas = new CaracteristicasTecnicas();

        caracteristicasTecnicas.setEspacioEnMemoria( caracteristicasSGBD.getEspacioEnMemoria() );
        caracteristicasTecnicas.setEspacionEnDisco( caracteristicasSGBD.getEspacionEnDisco() );
        caracteristicasTecnicas.setMultiplataforma( caracteristicasSGBD.getMultiplataforma() );

        return caracteristicasTecnicas;
    }

    private String caracteristicasSGBDHerramientaNombre(CaracteristicasSGBD caracteristicasSGBD) {
        if ( caracteristicasSGBD == null ) {
            return null;
        }
        Herramienta herramienta = caracteristicasSGBD.getHerramienta();
        if ( herramienta == null ) {
            return null;
        }
        String nombre = herramienta.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }
}
