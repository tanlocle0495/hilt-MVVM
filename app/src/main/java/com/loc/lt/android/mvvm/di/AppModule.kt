package com.loc.lt.android.mvvm.di
import com.loc.lt.android.mvvm.utils.security.SecurityUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class AppModule {
    @Provides
    @Singleton
    fun provideSecurityUtils(): SecurityUtils = SecurityUtils()
}