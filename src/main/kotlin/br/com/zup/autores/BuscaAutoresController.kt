package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

@Controller("/autores")
open class BuscaAutoresController(val autorRepository: AutorRepository) {

    @Get
    fun lista (@QueryValue(defaultValue = "") email: String) : HttpResponse<Any> {
        if (email.isBlank()) {
            val autores = autorRepository.findAll()

            val response = autores.map { autor -> DetalhesAutorResponse(autor) }

            return HttpResponse.ok(response)
        }

        val possivelAutor = autorRepository.findByEmail(email)
        if (possivelAutor.isEmpty) {
            return HttpResponse.notFound()
        }

        return HttpResponse.ok(DetalhesAutorResponse(possivelAutor.get()))
    }


}