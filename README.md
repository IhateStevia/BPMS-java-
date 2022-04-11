# BPMS-java-
Blood Pressure Monitor System (Java) 

BPMS PROJECT
Χρήστος Γεωργάκης: 228017

Περιγραφή:  Συσκευές (με διαφορετικά ID) πέρνουν μετρήσεις και τις στέλνουν με βοήθεια εφαρμογής σε κάποια database; από την οποία οι χρήστες μπορούν να τις ανακτήσουν/επεξεργαστούν (για το αντίσοιχο ID μόνο), με την βοήθεια μιας άλλης εφαρμογής.

Εφαρμογή-πελάτης για συσκευή (Client_device):

Readings_gen.java: Αυτή η κλάση δημιουργεί μετρήσεις με τις μεθόδους gen_.*

Readings_handler.java: Διαχείρηση τιμών με τις μεθόδους get.*/set.*

Readings.java: Ανάκτηση μετρήσεων/στοιχείων (μέσο Readings_handler που δημιουγήθηκαν με 			 Readings_gen) με την μέθοδο get

DB_handler.java: Διαχείρηση διασύνδεσης/επικοινονίας με την database  με τις παρακάτω 	μεθόδους →	
 
→ getConnection: επιστρέφει connection βάση των db_url (IP.link/όνομα_βάσης), usr pwd που 	έχουμε ορίσει κατά την δημιουργία ενος instance της DB_handler

→ existTable: ελένχει αν ύπαρχει ο πίνακας “readings” στην connection που δίνεται ως όρισμα, αν 	όχι, τότε τον δημιουργεί (μέσο exec) στην database μου αντιστοιχεί η connection

→ sendToDB: δημιουργεί connection (μέσο getConnection) και στέλνει τις τιμές (που δίνονται ως 	όρισμα) για εισαγωγή στον πίκανα “readings” αυτού του connection; αφού πρώτα γίνει 	έλενχος αν υπάρχει (μέσο existTable) και ύστερα κλείνει η σύνδεση.

→ exec: Eκτελεί το “query” που δίνεται ως όρισμα για την βάση που αντιστοιχεί το connection που 	δίνεται ως όρισμα.

BPM.java: Δημιουργεί instance του Readings_handler στο οποίο περνάει τιμές 	(τυχαίες/datetime/ConnINFO/id) μέσο της κλήσης μεθόδου get ανώνυμου αντικείμενου 	Readings. Υστερα στέλνει τις τιμές στην database μέσο κλήσης  της μεθόδου sendToDB  	ανώνυμου αντικειμένου DB_handler (για τις τιμέςConnINFO/id  που δίνονται από το 	instance του Readings_handler). 

ConnINFO.txt: Περιέχει τα στοιχεία της σύνδεσης με βάση  →

→γραμμή1: server_IP.link/database_name

→γραμμή2: database username

→γραμμή3: database password

id.txt: Περιέχει το “id” του χρήστη, στην πρώτη γραμμή.





Εφαρμογή-πελάτης για χρήστη (Client_user):

Txt_IO.java: Διαχείρηση ΙΟ με console/GUI/.txt με τις παρακάτω μεθόδους →

→get_1stLine: επιστρέφει σε String την πρώτη γραμμή του .txt, στην διαδρομή που ΄δεχεται ως 	όρισμα 

→getALL: επιστρέφει σε  πίνακα από String την καθεμιά από όλες της αντίστοιχες γραμμές του
	.txt, στην διαδρομή που ΄δεχεται ως όρισμα 

→printE: τυπώνει στο console τις τιμές που αντιστοιχούν στο καθένα από όλα τα Entry του 	Arraylist από Entry, που δέχεται ως όρισμα

→printD: τυπώνει στο TextArea (που αντιστοιχεί στο label του που δέχεται ως όρισμα), τις τιμές 	που αντιστοιχούν στο καθένα από όλα τα Entry του Arraylist από Entry, που δέχεται ως 	όρισμα

UI.java: Δημιουργεί GUI

Entry.java: (Oμοίως με Client_device.Reading_handler)++ →

 →sortBy_.*: κάνει sort τα Entry στο ArrayList που δέχεται ως είσοδο

 →rs2al: δέχεται ως είσοδο ResultSet και επιστρέφει Arraylist με Entry που έχουν ως τιμές, τις 	αντίστοιχες κάθε “γραμμής” του ResultSet

DB_handler.java: (Ομοίως με Client_device –sendToDB) ++ →

 →fetch: επιστρέφει Array από Entry, όπου κάθε Entry έχει τις τιμές ενός “tuple” του πίνακα 	“readings” (που αντιστοιχεί στο connection που δημιουργεί), μόνο για τα “tuples” με το id 	του χρήστη.

 →found: (Ομοίως με fetch)++ μόνο για “tuples” που περιέχουν το “keyword” που δίνεται το 	όρισμα

 →delete: διαγράφει το “tuple” που αντοιστιχεί στο κλειδί (που δίνεται ως όρισμα), στον πίνακα...
	μόνο αν το id του “tuple” είναι αυτό του χρήστη.

Main.java: Δημιουργεί ανώνυμο αντικείμενο UI με όρισμα το Array από Entry που επιστρέφει η 	μέθοδος fetch του ανώνυμου αντικείμενου DB_handler

ConnINFO.txt: (Ομοίως με Client_device)

id.txt: (Ομοίως με Client_device)
