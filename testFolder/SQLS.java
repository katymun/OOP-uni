public class SQLS {

    //sql pentru entitatea users
    public static String usersInsertDemo = "INSERT INTO `users` VALUES (NULL,'username1','pword123','2023-01-01')";
    public static final String usersInsert = "INSERT INTO users VALUES (NULL, ?, ?, ?)";

    //sql pentru entitatea recruiters
    public static String recruitersInsertDemo = "INSERT INTO `recruiters` VALUES (NULL,'nume1','prenume1','company1_id','user1_id','nume.prenume@gmail.com')";
    public static final String recruitersInsert = "INSERT INTO recruiters VALUES (NULL, ?, ?, ?, ?, ?)";

    //sql pentru entitatea aplicants
    public static String applicantsInsertDemo = "INSERT INTO `applicants` VALUES (NULL,'nume2','prenume2','20','student','IT','cv1.pdf','user1_id','nume.prenume@isa.utm.md','068111111')";
    public static final String applicantsInsert = "INSERT INTO applicants VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    //sql pentru entitatea companies
    public static String companiesInsertDemo = "INSERT INTO `companies` VALUES (NULL,'title1','IT','This is an IT company.','060123456','companyname@gmail.com')";
    public static final String companiesInsert = "INSERT INTO companies VALUES (NULL, ?, ?, ?, ?, ?)";

    //sql pentru entitatea programmes
    public static String programmesInsertDemo = "INSERT INTO `programmes` VALUES (NULL,'tilte2','IT','2023-01-01','3 months','Java development internship programme','company1_id')";
    public static final String programmesInsert = "INSERT INTO programmes VALUES (NULL, ?, ?, ?, ?, ?, ?)";

    //sql pentru entitatea applications
    public static String applicationsInsertDemo = "INSERT INTO `applications` VALUES (NULL,'applicant1_id','programme1_id','2023-01-01','cv1.pdf','068123123','nume.prenume@isa.utm.md','UTM')";
    public static final String applicationsInsert = "INSERT INTO applications VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";

	void gogogo() {
              System.out.println("gogogo");
}
}