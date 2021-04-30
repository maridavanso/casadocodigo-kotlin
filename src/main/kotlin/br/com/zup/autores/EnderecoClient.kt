package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client

@Client("http://localhost:8081/cep/")
interface EnderecoClient {

    @Get(consumes = [MediaType.APPLICATION_XML], produces = [MediaType.APPLICATION_XML])
    //@Consumes
    //@Produces
    fun consulta( @QueryValue cep: String) : HttpResponse<EnderecoResponse>

}
