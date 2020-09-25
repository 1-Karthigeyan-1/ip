# Duke project template

This is a project template for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
1. Set up the correct JDK version, as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Import the project into Intellij as follows:
   1. Click `Open or Import`.
   1. Select the project directory, and click `OK`
   1. If there are any further prompts, accept the defaults.
1. After the importing is complete, locate the `src/main/java/Duke.java` file, right-click it, and choose `Run Duke.main()`. If the setup is correct, you should see something like the below:
```
Hello! I'm Duke
What can I do for you?
```
## Features

### 1.  Adding a todo task: `Todo`  
Adds a Todo task  
Format: `todo <description>`  
Example: `todo homework`  
```
Got it. I've added this task:
[T][✘] homework
```

### 2. Adding a event task: `Event`  
Adds a Event task  
Format: `event <description> /at <date time>`  
Supported date time formats: `dd/MM/yyyy HHmm` `MMM dd yyy HH:mm`  
Example: `event party /at 31/12/2020 2300`  
```
Got it. I've added this task:
[E][✘] party (at: Dec 31 2020 23:00)
```

### 3. Adding a Deadline task: `Deadline`  
Adds a Deadline task  
Format: `deadline <description> /at <date time>`  
Supported date time formats: `dd/MM/yyyy HHmm` `MMM dd yyy HH:mm`  
Example: `deadline assignment /by 03/03/2020 2200`  
```
Got it. I've added this task:
[D][✘] assignment (by: Mar 03 2020 22:00)
```

### 4. Listing current tasks: `List`  
Shows a list of tasks in Duke  
Format: `list`  
Example: `list`  
```
Here are the tasks in your list:
1. [T][✘] homework
2. [E][✘] party (at: Dec 31 2020 23:00)
3. [D][✘] assignment (by: Mar 03 2020 22:00)
```

### 5. Complete task: `Done`  
Marks a task as completed  
Format: `done <number>`  
Example: `done 2`  
```
Nice! I've marked this task as done:
[E][✓] party (at: Dec 31 2020 23:00)
```
### 6. Find task: `Find`  
Finds a list of tasks matching the keyword  
Format: `find <keyword>`  
Example: `find home`  
```
Here are the tasks in your list:
1. [T][✘] homework
2. [T][✘] clean home
```
### 7. Remove task from list: `Delete`  
Deletes a task from list  
Format: `delete <number>`  
Example:  
List before deletion  
```
Here are the tasks in your list:
1. [T][✘] homework
2. [E][✓] party (at: Dec 31 2020 23:00)
3. [D][✘] assignment (by: Mar 03 2020 22:00)
4. [T][✘] clean home
```
`delete 4`
```
Noted. I've removed this task:
  [T][✘] clean home
Now you have 3 tasks in the list
```
List after deletion  
```
Here are the tasks in your list:
1. [T][✘] homework
2. [E][✓] party (at: Dec 31 2020 23:00)
3. [D][✘] assignment (by: Mar 03 2020 22:00)
```
### 8. Exit the Duke program: `bye`  
Safely exits the Duke program  
Format: `bye`  
Example: `bye`  
```
Bye. Hope to see you again soon!  
```
### 9. Saving data  
Tasks data is saved in the hard disk automatically.  
This includes commands that change or edit the data.  

### 10. Loading data  
Tasks data is stored in `data/tasks.txt` file.   
If no such file or directory is found, a new `data/tasks.txt` is created.  

## Command Summary  
|**Action** | **Format** |  

|---|---|

| **Todo** | `todo <description>` | 
| **Event** | `event <description> /at <date time>` | 
| **Deadline** | `deadline <description> /at <date time>` |
| **List** | `list` |
| **Done** | `done <number>` |
| **Find** | `find <keyword>` |
| **Delete** | `delete <number>` |
| **Exit** | `bye` |

