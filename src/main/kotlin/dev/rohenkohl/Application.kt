package dev.rohenkohl

import dev.rohenkohl.domain.service.DiscordService
import dev.rohenkohl.domain.service.LudolphService
import io.quarkus.scheduler.Scheduled
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class Application(val discordService: DiscordService, val ludolphService: LudolphService) {

    @Scheduled(every = "\${ludolph.scheduler.rate}")
    fun schedule() {
        ludolphService.updateChange()
        ludolphService.updatePosition()
    }
}