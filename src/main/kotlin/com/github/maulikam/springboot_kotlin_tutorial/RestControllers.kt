package com.github.maulikam.springboot_kotlin_tutorial

import org.springframework.http.HttpStatus
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
class ArticleController {

    val articles = mutableListOf(Article(title="my title",
                    content = "my content"))

    @GetMapping
    fun articles() = articles

    @GetMapping("/{title}")
    fun articles(@PathVariable title : String) =
        articles.find { article -> article.title == title } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @PostMapping
    fun newArticle(@RequestBody article: Article) : Article {
        this.articles.add(article)
        return article
    }

    @PutMapping("/{title}")
    fun updateArticle(@RequestBody article: Article, @PathVariable title: String) : Article {
        val existingArticle = articles.find { it.title == title } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        existingArticle.content = article.content
    }

}
