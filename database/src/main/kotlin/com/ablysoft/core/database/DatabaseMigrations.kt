package com.ablysoft.core.database

import androidx.room.RenameColumn
import androidx.room.migration.AutoMigrationSpec

/**
 * Automatic schema migrations sometimes require extra instructions to perform the migration, for
 * example, when a column is renamed. These extra instructions are placed here by creating a class
 * using the following naming convention `SchemaXtoY` where X is the schema version you're migrating
 * from and Y is the schema version you're migrating to. The class should implement
 * `AutoMigrationSpec`.
 */
internal object DatabaseMigrations {

    @RenameColumn(
        tableName = "posts",
        fromColumnName = "body",
        toColumnName = "description",
    )
    class Schema1to2 : AutoMigrationSpec

    @RenameColumn(
        tableName = "posts",
        fromColumnName = "description",
        toColumnName = "shortDescription",
    )
    class Schema2to3 : AutoMigrationSpec

}
