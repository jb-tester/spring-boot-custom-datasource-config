## Multiple custom datasources configuration via configuration properties

* https://youtrack.jetbrains.com/issue/IDEA-342198 SpringBoot: custom datasource configuration properties are not resolved
(https://youtrack.jetbrains.com/issue/IDEA-343779 @ConfigurationProperties method keys with library return type not collected)

**problems**: FIXED?
- the custom configuration properties defined via `@ConfigurationProperties`-annotated
  beans of `org.springframework.boot.autoconfigure.jdbc.DataSourceProperties` type are not resolved: 
   see the H2DatasourceConfiguration class
- the custom datasource properties defined via `@ConfigurationProperties`-annotated 
  beans of `org.springframework.boot.autoconfigure.jdbc.Datasource` type are not resolved:
  see the MySqlDatasourceConfiguration class
   https://youtrack.jetbrains.com/issue/IDEA-346177 



