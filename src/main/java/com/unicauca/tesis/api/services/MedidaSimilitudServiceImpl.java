package com.unicauca.tesis.api.services;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.text.similarity.CosineSimilarity;
import org.springframework.stereotype.Service;

@Service
public class MedidaSimilitudServiceImpl implements IMedidaSimilitudService {

	@Override
	public Double calcularPonderadoParaTextos(String textoAlmacenado, String textoEntrada) {
		
		CosineSimilarity documentsSimilarity = new CosineSimilarity();

		Map<CharSequence, Integer> vectorA = Arrays.stream(textoEntrada.split(","))
				.collect(Collectors.toMap(character -> character, character -> 1, Integer::sum));
		Map<CharSequence, Integer> vectorB = Arrays.stream(textoAlmacenado.split(","))
				.collect(Collectors.toMap(character -> character, character -> 1, Integer::sum));

		Double docABCosSimilarity = documentsSimilarity.cosineSimilarity(vectorA, vectorB);

		return docABCosSimilarity;
	}

	public String realizarPreProcesamiento(String datoAlmacenado, String datoEntrada) {

		String[] arregloEntrada = datoEntrada.split(",");
		String[] arregloAlmacenado = datoAlmacenado.split(",");

		List<String> resultadoProcesado = Arrays.stream(arregloAlmacenado).filter(x -> existeElCampo(x, arregloEntrada))
				.collect(Collectors.toList());

		return String.join(",", resultadoProcesado);
	}

	private Boolean existeElCampo(String campo, String[] arregloEntrada) {
		return Arrays.stream(arregloEntrada).anyMatch(x -> x.equals(campo));
	}
}
