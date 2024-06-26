package com.vaskorr.gitloader.data.internal.local

import android.os.Environment
import android.util.Log
import com.vaskorr.gitloader.data.internal.local.db.RepositoryDao
import com.vaskorr.gitloader.data.internal.local.model.Repository
import com.vaskorr.gitloader.domain.model.GitRepository
import com.vaskorr.gitloader.domain.usecase.LocalRepository
import java.io.File
import java.net.URI
import java.net.URL

internal class LocalRepositoryImpl(
    private val repositoryDao: RepositoryDao
) : LocalRepository {
    override fun getDownloadedRepositories(): List<GitRepository> {
        val repositoryList = mutableListOf<GitRepository>()
        repositoryDao.getAll().forEach {
            repositoryList.add(
                GitRepository(
                    label = it.label,
                    owner = it.owner,
                    url = URL(it.url),
                    downloadedFileUri = URI(it.uri)
                )
            )
        }
        return repositoryList
    }

    override fun addRepository(repository: GitRepository) {
        repositoryDao.insert(
            Repository(
                label = repository.label,
                owner = repository.owner,
                uri = repository.downloadedFileUri.toString(),
                url = repository.url.toString()
            )
        )
    }

    override fun deleteRepository(repository: GitRepository) {
        Log.d("DELETE", repository.toString())
        repositoryDao.deleteByName(repository.owner, repository.label).toString()
        Log.d("OSTALOS", getDownloadedRepositories().toString())
        val uri = "${
            Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS
            )
        }/${repository.label}.zip"
        File(uri).delete()
    }
}