package com.github.maulikam.springboot_kotlin_tutorial

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/articles")
class ArticleController (val repository: ArticleRepository) {


//    val articles = mutableListOf(Article(title="my title",
//        content = "my content"))

//    @GetMapping
//    fun articles() = articles

    @GetMapping
    fun articles() = repository.findAllByOrderByCreatedAtDesc()

    @GetMapping("/{slug}")
    fun articles(@PathVariable slug : String) =
        repository.findBySlug(slug).orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND) }
//        articles.find { article -> article.slug == slug } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @PostMapping
    fun newArticle(@RequestBody article: Article) : Article {
        article.id = null
         repository.save(article)
//        this.articles.add(article)
        return article
    }

    @PutMapping("/{slug}")
    fun updateArticle(@RequestBody article: Article, @PathVariable slug: String) : Article {
        val existingArticle = repository.findBySlug(slug).orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND) }
//        val existingArticle = articles.find { it.slug == slug } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        existingArticle.content = article.content
        existingArticle.title = article.title
        return article
    }

    @DeleteMapping("/{slug}")
    fun deleteArticle(@PathVariable slug: String) : ResponseEntity<Void> {
//        val isRemoved = articles.removeIf { article -> article.slug == slug}

        val exitingArticle = repository.findBySlug(slug).orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND )}

        repository.delete(exitingArticle)

        return ResponseEntity(HttpStatus.NO_CONTENT)

    }

}
