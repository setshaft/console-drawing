package com.drawingprogram.commands;

import com.drawingprogram.exceptions.InvalidCommandArguments;
import com.drawingprogram.exceptions.InvalidCommandException;
import com.drawingprogram.interfaces.CommandType;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandProcessorTest {

    private CommandProcessor command;

    @Before
    public void setUp() throws Exception {
        command = new CommandProcessor();
    }

    @Test
    public void getCommand() throws Exception {
        command.getCommand("Q");
    }

    @org.junit.Test(expected = InvalidCommandException.class)
    public void getCommand2() throws Exception {
        command.getCommand("A");
    }

    @Test
    public void getCommand3() throws Exception {
        CommandType commandType = command.getCommand("C 20 4");
        Assert.assertThat(commandType, CoreMatchers.instanceOf(CreateCanvas.class));
    }

    // @org.junit.Test(expected = InvalidCommandArguments.class)
    // public void getCommand32() throws Exception {
    // command.getCommand("C 20 -4");
    // }

    @Test
    public void getCommand4() throws Exception {
        CommandType commandType = command.getCommand("L 1 2 1 22");
        Assert.assertThat(commandType, CoreMatchers.instanceOf(DrawLine.class));
    }

    // @org.junit.Test(expected = InvalidCommandArguments.class)
    // public void getCommand42() throws Exception {
    // command.getCommand("L 1 2 1 -22");
    // }

    @Test
    public void getCommand5() throws Exception {
        CommandType commandType = command.getCommand("R 14 1 18 3");
        Assert.assertThat(commandType, CoreMatchers.instanceOf(DrawRectangle.class));
    }

    // @org.junit.Test(expected = InvalidCommandArguments.class)
    // public void getCommand52() throws Exception {
    // command.getCommand("R 14 1 18 -3");
    // }

    @Test
    public void getCommand6() throws Exception {
        CommandType commandType = command.getCommand("B 1 3 o");
        Assert.assertThat(commandType, CoreMatchers.instanceOf(DrawFill.class));
    }

    @Test(expected = InvalidCommandArguments.class)
    public void getCommand62() throws Exception {
        command.getCommand("B 1 3 oo");
    }

}