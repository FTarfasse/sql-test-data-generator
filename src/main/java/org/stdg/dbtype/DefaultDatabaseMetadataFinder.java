/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2021-2021 the original author or authors.
 */

package org.stdg.dbtype;

import org.stdg.ColumnsMappingGroup;
import org.stdg.DatabaseMetadataFinder;
import org.stdg.ReferencedTableSet;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

class DefaultDatabaseMetadataFinder implements DatabaseMetadataFinder {


    private final DefaultNotNullColumnsFinder defaultNotNullColumnsFinder;

    public DefaultDatabaseMetadataFinder(DataSource dataSource) {
        this.defaultNotNullColumnsFinder = new DefaultNotNullColumnsFinder(dataSource);
    }

    @Override
    public List<String> findDatabaseColumnOrdersOf(String tableName) {
        return Collections.emptyList();
    }

    @Override
    public ReferencedTableSet findReferencedTablesOf(String tableName) {
        return ReferencedTableSet.NONE;
    }

    @Override
    public List<String> findNotNullColumnsOf(String tableName) {
        return defaultNotNullColumnsFinder.findNotNullColumnsOf(tableName);
    }

    @Override
    public ColumnsMappingGroup findColumnsMappingsOf(String tableName) {
        return ColumnsMappingGroup.NO_MAPPING;
    }

    @Override
    public List<String> findPrimaryColumnsOf(String tableName) {
        return Collections.emptyList();
    }

}
