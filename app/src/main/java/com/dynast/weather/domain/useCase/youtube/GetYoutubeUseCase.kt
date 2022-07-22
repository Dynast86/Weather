package com.dynast.weather.domain.useCase.youtube

import com.dynast.weather.data.remote.repository.YoutubeRepository
import com.dynast.weather.domain.model.youtube.YoutubeData
import com.dynast.weather.extension.di.IoDispatcher
import com.dynast.weather.extension.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetYoutubeUseCase @Inject constructor(
    private val repository: YoutubeRepository,
    @IoDispatcher val coroutineDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(): Resource<YoutubeData> {
        return try {
            withContext(context = coroutineDispatcher) {
                val resultDeferred = async { repository.getYoutubeData() }
                Resource.Success(data = resultDeferred.await())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = e.message ?: "알수없는 에러가 발생했습니다.")
        }
    }
}