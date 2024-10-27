package com.github.maulikam.springboot_kotlin_tutorial

import java.time.LocalDateTime

data class Article(
    var title: String?,
    var content: String,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var slug: String? = title?.toSlug()) // check for null safe before converting into slug
