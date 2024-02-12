package dev.feliperf.plugins.Commands

import dev.feliperf.plugins.Contants.SpecificPermissions
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object KillCmd : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>,): Boolean {

        if (SpecificPermissions.canBeAdmin(sender.name)) {
            val player = (sender as Player)

            if (args.isEmpty()) {
                player.damage(100.0, player)
            } else {
                val target = Bukkit.getPlayer(args.first())
                player.damage(100.0, target)
            }

            return sender.isOnline
        }

        sender.sendMessage("Você não tem permissão de ADMIN para executar este comando!")

        return false
    }


}