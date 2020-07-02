### Scheduling Calls - instructions for managing outbound HTTP calls in Pivotal Scheduler

##### Step 1 : To use the Cloud Foundry Command Line Interface (cf CLI) for managing calls, you must install the Pivotal Scheduler CLI plugin on your local machine. This plugin is packaged with the Pivotal Scheduler tile on Pivotal Network.
```cf install-plugin scheduler-for-pcf-cliplugin-macosx64-binary-1.2.1-build.4```
##### Step 2 : Create scheduler instance
##### Step 3 : Bind the service to the created scheduler instance
``cf bind-service {SERVICE-NAME} {SCHEDULER-NAME}``
##### Step 4 : Create a call for the POST endpoint URL
``cf create-call {APP-NAME} {CALL-NAME} {URL}``
##### Step 5 : To execute a created call
``cf run-call {CALL-NAME}``
##### Step 6 : To schedule a call for every x minutes
``cf schedule-call {CALL-NAME} "*/x * ? * *"``
##### Step 7 : To list all the calls
``cf calls``
##### Step 8 : To list all the schedules
`` cf call-schedules``
##### Step 9 :To view specific call history
`` cf call-history {CALL-NAME}`` 
