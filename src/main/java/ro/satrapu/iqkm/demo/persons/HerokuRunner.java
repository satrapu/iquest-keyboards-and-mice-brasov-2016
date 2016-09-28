package ro.satrapu.iqkm.demo.persons;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourceArchive;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Bootstraps WildFly Swarm on <a href="https://www.heroku.com/home">Heroku</a> cloud application platform.
 */
public class HerokuRunner {
    private static final String ENVIRONMENT_VARIABLE_DATABASE_URL = "DATABASE_URL";
    private static final String JDBC_URL_PREFIX = "jdbc:postgresql://";
    private static final String JDBC_DRIVER_NAME = "postgresql";
    private static final String DATASOURCE_NAME = "HerokuDS";

    /**
     * Starts a WildFly Swarm container.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();
        swarm.start();

        //ensure the Heroku datasource is deployed before the JEE application, so that the latter's persistence unit
        // will be able to find a suitable datasource
        swarm.deploy(buildDatasourceArchive(System.getenv(ENVIRONMENT_VARIABLE_DATABASE_URL))).deploy();

        //deploy the JEE 7 application, containing configured Swarm fractions like CDI, EJB, etc.
        swarm.deploy();
    }

    /**
     * Creates a {@link DatasourceArchive} instance pointing to the Heroku managed PostgreSQL database.
     *
     * @param databaseUrl The URL pointing to the Heroku managed PostgreSQL database -
     *                    see more <a href="https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java#using-the-database_url-in-plain-jdbc">here</a>.
     */
    private static DatasourceArchive buildDatasourceArchive(String databaseUrl) throws URISyntaxException {
        URI dbUri = new URI(databaseUrl);
        String userInfo = dbUri.getUserInfo();
        String userName = null;
        String password = null;

        if (userInfo != null) {
            userName = userInfo.split(":")[0];
            password = userInfo.split(":")[1];
        }

        String jdbcUrl =
                JDBC_URL_PREFIX
                        + dbUri.getHost()
                        + ":" + dbUri.getPort()
                        + dbUri.getPath()
                        + (dbUri.getQuery() != null ? "?" + dbUri.getQuery() : "");

        String finalUserName = userName;
        String finalPassword = password;

        DatasourceArchive datasourceArchive = ShrinkWrap.create(DatasourceArchive.class);
        datasourceArchive.dataSource(DATASOURCE_NAME, dataSource -> {
            dataSource.connectionUrl(jdbcUrl);
            dataSource.driverName(JDBC_DRIVER_NAME);

            if (finalUserName != null) {
                dataSource.userName(finalUserName);
            }

            if (finalPassword != null) {
                dataSource.password(finalPassword);
            }
        });

        return datasourceArchive;
    }
}
