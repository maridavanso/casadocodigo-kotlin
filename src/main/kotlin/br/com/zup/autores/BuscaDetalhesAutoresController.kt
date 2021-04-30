package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/autores")
open class BuscaDetalhesAutoresController(val autorRepository: AutorRepository) {

    @Get
    fun lista() : HttpResponse<List<DetalhesAutorResponse>> {
        val autores = autorRepository.findAll()

        val resposta = autores.map { autor -> DetalhesAutorResponse(autor) }

        return HttpResponse.ok(resposta)
    }


}