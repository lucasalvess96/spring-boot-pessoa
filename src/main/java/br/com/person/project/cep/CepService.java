package br.com.person.project.cep;

import br.com.person.project.comon.EntityNotFoundExceptiion;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Service
public class CepService {

    private static final String API_URL = "https://viacep.com.br/ws/%s/json/";

    private final RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(CepService.class);

    public CepService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CepDto findCep(String cep) {
        try {
            String url = String.format(API_URL, cep);

            return restTemplate.getForObject(url, CepDto.class);
        } catch (Exception ex) {
            logger.error("Erro ao consultar cep: ", ex);
            throw new EntityNotFoundExceptiion("ERRO AO CONSULTAR CEP");
        }
    }
}
