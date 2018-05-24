package com.app.jsonexample

data class ModelData(var main_title: String, var category: List<Category>) {
    data class Category(var sub_title: String, var tags: String)
}









