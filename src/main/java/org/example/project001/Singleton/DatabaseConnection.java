package org.example.project001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {

    private static DatabaseConnection instance = null;

    // 데이타베이스에 연결하려는 파라미터 값(매개변수)
    // dbConn이 null 이면, 연결된 것이 없으니 연결해야 한다.
    private String dbDriver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/towncafe";
    private String User = "root";
    private String Password = "1234";

    // 연결객체
    private Connection dbConn = null;


    // db 와 연결을 설정하는 메서드
    public void Connect() {
        if (dbConn!= null){
            System.out.println("DB 연결이 이미 되어 있습니다.");
            return;
        }

        // 데이터베이스 드라이버 로드
        try {
            Class.forName(dbDriver);

            // 연결 설정
            dbConn = DriverManager.getConnection(url, User, Password);
            System.out.println("DB Connection [성공] + Connecting to the database...");

        } catch (SQLException e) {
            System.out.println("DB Connection [실패]");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println("DB Connection [실패]");
            e.printStackTrace();
        }

    }

    // 데이터베이스 연결을 닫는 메서드
//    public void close() {
//        if (dbConn != null){
//            try{
//                dbConn.close();
//                System.out.println("DB 연결 종료");
//            } catch (SQLException e){
//                System.out.println("DB 연결 종료 중 오류 발생");
//                e.printStackTrace();
//            }
//
//        }
//    }

// 정적 메서드 : Singleton 인스턴스 반환
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

//    // 연결 객체를 반환하는 getter 메서드
//    public Connection getDbConn() {
//        return dbConn;
//    }

    // main 메서드 (프로그램 실행)
    // 싱글톤 패턴에서만 사용할 수 있는 메서드 getInstance()
    // 클래스 인스턴스 하나만 생성. 클래스의 유일한 인스턴스를 가져와 사용
    public static void main(String[] args) {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        System.out.println(dbConnection);
        dbConnection.Connect();
//        dbConnection.close();
    }
}
