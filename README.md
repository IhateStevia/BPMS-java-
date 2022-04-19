# BPMS-java-
Blood Pressure Monitor System (Java) 

Client_device generates a set of random data (emulating the readings of a bpm device) and uploads them to the database, with the id of  id.txt. (if the needed table is not present, will be created). 

Client_user fetches readings uploaded to the database (only the ones with id, matching the id on id.txt) and interfaces them to the user, with the options to sort them, delete them or search for a certain reading.

You can download the runable jars, from runable jars folder. 
! ConnINFO.txt and id.txt need to be present in the same folder as the runable files.

ConnINFO.txt: Contains the information needed to connect to an SQL database

1st line: database location ex: sql11.freesqldatabase.com:3306/sql11486877

2nd line: username ex: sql11486877

3rd line: password ex: Q7ajvpweSa

id.txt: Contains the id of the user (can be anything, but have to be the same id Client_user as in Client_device).

Client_user/Client_device can be in seperate folders, but a set of ConnINFO.txt/id.txt is needed for each.


