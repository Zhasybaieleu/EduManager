package PostgreSql;

import java.sql.*;

public class PostgreSQL {
    private static final String url = "jdbc:postgresql://localhost:5432/Hogwarts";
    private static final String username = "postgres";
    private static final String password = "password";
    private Connection connection;
    public PostgreSQL() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Подключение к базе данных установлено.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                    "id SERIAL PRIMARY KEY, " +
                    "login VARCHAR(100), " +
                    "password VARCHAR(100))";
            statement.executeUpdate(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(String login, String password) {
        String sql = "INSERT INTO users (login, password) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableCourse(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS course (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(100))";
            statement.executeUpdate(sql);
            System.out.println("Таблица с курсами создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCourse(String name){
        String sql = "INSERT INTO course (name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTableSubject(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS subject (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(100))";
            statement.executeUpdate(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSubject(String name){
        String sql = "INSERT INTO subject (name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTableResearchProject(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS researchProject (" +
                    "id SERIAL PRIMARY KEY, " +
                    "topic VARCHAR(100))";
            statement.executeUpdate(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertResearchProject(String topic){
        String sql = "INSERT INTO  researchProject (topic) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, topic);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTableResearchPaper(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS researchPaper (" +
                    "id SERIAL PRIMARY KEY, " +
                    "doi VARCHAR(100), " +
                    "title VARCHAR(100), " +
                    "author VARCHAR(100), " +
                    "pages INTEGER, " +
                    "year INTEGER, " +
                    "citations INTEGER, " +
                    "publisher VARCHAR(100))";
            statement.executeUpdate(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertResearchPaper(String doi, String title, String author, int pages, int year, int citations, String publisher){
        String sql = "INSERT INTO researchPaper (doi, title, author, pages, year, citations, publisher) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, doi);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, author);
            preparedStatement.setInt(4, pages);
            preparedStatement.setInt(5, year);
            preparedStatement.setInt(6, citations);
            preparedStatement.setString(7, publisher);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTableNews(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS news (" +
                    "id SERIAL PRIMARY KEY, " +
                    "topic VARCHAR(100), " +
                    "comments VARCHAR(200))";
            statement.executeUpdate(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertNews(String topic, String comments){
        String sql = "INSERT INTO news (topic, comments) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, topic);
            preparedStatement.setString(2, comments);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTableJournal(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS journal (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(100), " +
                    "subscribers INTEGER )";
            statement.executeUpdate(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertJournal(String name, int subscribes){
        String sql = "INSERT INTO journal (name, subscribes) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, subscribes);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTableLogs(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS logs (" +
                    "id SERIAL PRIMARY KEY, " +
                    "action VARCHAR(100))";
            statement.executeUpdate(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertLogs(String action){
        String sql = "INSERT INTO logs (action) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, action);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTableStudentOrganizations(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS StudentOrganizations (" +
                    "id SERIAL PRIMARY KEY, " +
                    "orgName VARCHAR(100), " +
                    "members TEXT, " +
                    "head VARCHAR(100))";
            statement.executeUpdate(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertStudentOrganizations(String orgName, String members, String head){
        String sql = "INSERT INTO StudentOrganizations (orgName, members, head) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, orgName);
            preparedStatement.setString(2, members);
            preparedStatement.setString(3, head);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTableOffices(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS offices (" +
                    "id SERIAL PRIMARY KEY, " +
                    "faculty VARCHAR(100), " +
                    "dean VARCHAR(100))";
            statement.executeUpdate(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOffices(String orgName, String members, String head){
        String sql = "INSERT INTO offices (orgName, members, head) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, orgName);
            preparedStatement.setString(2, members);
            preparedStatement.setString(3, head);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTableRector(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS rector (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(100))";
            statement.executeUpdate(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertRector(String name){
        String sql = "INSERT INTO rector (name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTableLanguage(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS language (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(10))";
            statement.executeUpdate(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertLanguage(String name){
        String sql = "INSERT INTO language (name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTableTopCitedResearcher(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS TopCitedResearcher (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(10))";
            statement.executeUpdate(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertTopCitedResearcher(String name){
        String sql = "INSERT INTO TopCitedResearcher (name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTablePeriod(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS period (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(10))";
            statement.executeUpdate(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPeriod(String name){
        String sql = "INSERT INTO period (name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTableYear(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS year (" +
                    "id SERIAL PRIMARY KEY, " +
                    "currentYear INTEGER)";
            statement.executeUpdate(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertYear(int currentYear){
        String sql = "INSERT INTO year (currentYear) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, currentYear);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTableRegistrationIsOpen(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS registrationIsOpen (" +
                    "id SERIAL PRIMARY KEY, " +
                    "yesOrNo VARCHAR(10))";
            statement.executeUpdate(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertRegistrationIsOpen(String yesOrNo){
        String sql = "INSERT INTO registrationIsOpen (yesOrNo) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, yesOrNo);
            preparedStatement.executeUpdate();
            System.out.println("Данные пользователя добавлены.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        PostgreSQL pg = new PostgreSQL();
        pg.createTable();
        pg.insertUser("JAMES BOND", "007");
        pg.insertUser("Leonardo Da vinci","1513" );
    }
}
