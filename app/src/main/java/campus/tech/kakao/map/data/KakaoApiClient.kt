package campus.tech.kakao.map.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KakaoApiClient {
    companion object {
        private const val BASE_URL = "https://dapi.kakao.com/"
        private const val API_KEY = "KakaoAK 64460f87dcdc8b7c641aae6a19a7509f"

        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", API_KEY)
                    .build()
                chain.proceed(request)
            }
            .build()

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun createService(): KakaoLocalApiService {
            return retrofit.create(KakaoLocalApiService::class.java)
        }
    }
}