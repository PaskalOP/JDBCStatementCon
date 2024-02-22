package org.example.jdbcWork.servise;

import org.example.jdbcWork.Database;

public class DatabaseInitService {
    public static void main(String[] args) {
        Database db = Database.getInstance();
       // db.execute("/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/cteateTableWorker.sql");
       // db.execute("/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/createTableClient.sql");
        //db.execute("/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/createTableProject.sql");
        //db.execute("/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/creartTableProjectWorker.sql");
        //db.execute("/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/createSeqeunce.sql");
        //db.execute("/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/connectProjectClient.sql");
        db.execute("/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/addMonthCountCol.sql");
        db.execute("/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/addProjectCountCollumn.sql");
    }
}