package hu.zsoltkiss.githubsearch.data.api

import hu.zsoltkiss.githubsearch.data.model.SearchRepositoryResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GitHubApi {

    @Headers("Accept: application/json")
    @GET("search/repositories")
    suspend fun getRepositoriesByQuery(@Query("q") query: String): Response<SearchRepositoryResult>
}