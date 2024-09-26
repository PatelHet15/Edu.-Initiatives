
interface Command {
  void execute();
}


class LightOnCommand implements Command {
  public void execute() {
      System.out.println("Light is turned ON");
  }
}

class LightOffCommand implements Command {
  public void execute() {
      System.out.println("Light is turned OFF");
  }
}


class RemoteControl {
  private Command command;
  
  public void setCommand(Command command) {
      this.command = command;
  }
  
  public void pressButton() {
      command.execute();
  }
}


public class CommandPatternDemo {
  public static void main(String[] args) {
      RemoteControl remote = new RemoteControl();
      
      Command lightOn = new LightOnCommand();
      Command lightOff = new LightOffCommand();
      
      remote.setCommand(lightOn);
      remote.pressButton(); 
      
      remote.setCommand(lightOff);
      remote.pressButton(); 
  }
}
