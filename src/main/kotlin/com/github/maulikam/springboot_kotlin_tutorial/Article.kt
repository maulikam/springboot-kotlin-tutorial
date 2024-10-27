package com.github.maulikam.springboot_kotlin_tutorial

import java.time.LocalDateTime

data class Article(
    val title: String?,
    val content: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val slug: String? = title?.toSlug()) // check for null safe before converting into slug
