package co.apploop.ktorexample.model

data class Response(
    val data: List<Data>,
    val message: String? = null,
    val status: String? = null
)

data class Data(
    val employee_name: String? = null,
    val employee_age: Int? = 0,
    val employee_salary: Int? = 0,
    val id: Int? = 0,
    val profile_image: String? = null
)