package org.example.jdbcWork.servise;

import org.example.jdbcWork.Database;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database db = Database.getInstance();
  //      db.execute("/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/insertIntoClietn.sql");
   //     db.execute("/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/insertIntoWorker.sql");
      //  db.execute("/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/insertIntoProject.sql");
       db.execute("/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/insertIntoProjectWorcer.sql");
    }

}
