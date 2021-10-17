package com.example.daggerexample.di

import com.example.daggerexample.MainActivity
import com.example.daggerexample.data.Computer
import com.example.daggerexample.data.Motherboard
import com.example.daggerexample.data.Processor
import com.example.daggerexample.data.RAM
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [AppModule::class])
interface AppComponent {
    fun computer(): Computer
    fun inject(activity: MainActivity) {
    }
}

@Module
object AppModule {
    fun provideComputer(
        processor: Processor,
        motherboard: Motherboard,
        ram: RAM
    ): Computer {
        return Computer(
            processor = processor,
            motherboard = motherboard,
            ram = ram
        )
    }

    @Provides
    fun provideProcessor(): Processor {
        return Processor()
    }

    @Provides
    fun provideMotherboard(): Motherboard {
        return Motherboard()
    }

    @Provides
    fun provideRam(): RAM {
        return RAM()
    }
}
