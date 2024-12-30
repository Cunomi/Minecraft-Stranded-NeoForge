package com.dotnomi.stranded.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;

public class ResetPlayerCommand {


  private ArgumentBuilder<CommandSourceStack, ?> test;


  public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
    dispatcher.register(Commands.literal("reset")
        .requires(cs -> cs.hasPermission(2))
      .then(Commands.argument("player", EntityArgument.player())
        .executes(context -> {
          runCommandWithPlayer(context);
          return Command.SINGLE_SUCCESS;
        })
        .then(Commands.argument("message", StringArgumentType.string())
          .executes(context -> {
            runCommandWithMessage(context);
            return Command.SINGLE_SUCCESS;
          }))));
  }

  private static void runCommandWithPlayer(CommandContext<CommandSourceStack> context) {
    try {
      var player = EntityArgument.getPlayer(context, "player");
      context.getSource().sendSuccess(() ->
        Component.literal("Du hast den Spieler ausgewählt: " + player.getName().getString()), false);
    } catch (Exception e) {
      context.getSource().sendFailure(Component.literal("Spieler nicht gefunden!"));
    }
  }

  private static void runCommandWithMessage(CommandContext<CommandSourceStack> context) {
    String message = StringArgumentType.getString(context, "message");
    context.getSource().sendSuccess(() ->
      Component.literal("Du hast gesagt: " + message), false);
  }
}
