package com.unicauca.tesis.api.mappers;

import com.unicauca.tesis.api.models.DTO.request.CaracteristicasTecnicas;
import com.unicauca.tesis.api.models.DTO.request.Costo;
import com.unicauca.tesis.api.models.DTO.request.Documentacion;
import com.unicauca.tesis.api.models.DTO.request.ETL;
import com.unicauca.tesis.api.models.DTO.request.FuncionalidadesETL;
import com.unicauca.tesis.api.models.entities.CaracteristicasETL;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-01T21:27:49-0500",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.5 (Eclipse Adoptium)"
)
public class ResponseETLMapperImpl implements ResponseETLMapper {

    @Override
    public ETL convertCaracteristicasETLEntityAETL(CaracteristicasETL caracteristicasETL) {
        if ( caracteristicasETL == null ) {
            return null;
        }

        ETL eTL = new ETL();

        eTL.setDocumentacionETL( caracteristicasETLToDocumentacion( caracteristicasETL ) );
        eTL.setCostoETL( caracteristicasETLToCosto( caracteristicasETL ) );
        eTL.setCaracTecETL( caracteristicasETLToCaracteristicasTecnicas( caracteristicasETL ) );
        eTL.setFuncionalidadesETL( caracteristicasETLToFuncionalidadesETL( caracteristicasETL ) );

        return eTL;
    }

    protected Documentacion caracteristicasETLToDocumentacion(CaracteristicasETL caracteristicasETL) {
        if ( caracteristicasETL == null ) {
            return null;
        }

        Documentacion documentacion = new Documentacion();

        documentacion.setValor( caracteristicasETL.getDocumentacion() );

        return documentacion;
    }

    protected Costo caracteristicasETLToCosto(CaracteristicasETL caracteristicasETL) {
        if ( caracteristicasETL == null ) {
            return null;
        }

        Costo costo = new Costo();

        costo.setValor( caracteristicasETL.getCosto() );

        return costo;
    }

    protected CaracteristicasTecnicas caracteristicasETLToCaracteristicasTecnicas(CaracteristicasETL caracteristicasETL) {
        if ( caracteristicasETL == null ) {
            return null;
        }

        CaracteristicasTecnicas caracteristicasTecnicas = new CaracteristicasTecnicas();

        caracteristicasTecnicas.setEspacioEnMemoria( caracteristicasETL.getEspacioEnMemoria() );
        caracteristicasTecnicas.setEspacionEnDisco( caracteristicasETL.getEspacionEnDisco() );
        caracteristicasTecnicas.setMultiplataforma( caracteristicasETL.getMultiplataforma() );

        return caracteristicasTecnicas;
    }

    protected FuncionalidadesETL caracteristicasETLToFuncionalidadesETL(CaracteristicasETL caracteristicasETL) {
        if ( caracteristicasETL == null ) {
            return null;
        }

        FuncionalidadesETL funcionalidadesETL = new FuncionalidadesETL();

        return funcionalidadesETL;
    }
}
