class TeacherCommandInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        if (command != null) {
            command.execute(1);
        } else {
            System.out.println("No command set for execution.");
        }
    }
}