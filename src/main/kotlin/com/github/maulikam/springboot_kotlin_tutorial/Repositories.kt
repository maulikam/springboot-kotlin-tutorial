package com.github.maulikam.springboot_kotlin_tutorial

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ArticleRepository : JpaRepository<Article, Long> {
    fun findAllByOrderByCreatedAtDesc() : Iterable<Article>


    fun findBySlug(slug : String): Optional<Article>
}