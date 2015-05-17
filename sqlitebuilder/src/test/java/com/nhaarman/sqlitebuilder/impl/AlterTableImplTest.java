/*
 *  Copyright 2015 Niek Haarman
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.nhaarman.sqlitebuilder.impl;

import com.nhaarman.sqlitebuilder.AddColumn;
import com.nhaarman.sqlitebuilder.Column;
import com.nhaarman.sqlitebuilder.RawSqlBuilder;
import com.nhaarman.sqlitebuilder.RenameTo;
import com.nhaarman.sqlitebuilder.SqlPart;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.*;

@SuppressWarnings("HardCodedStringLiteral")
public class AlterTableImplTest {

  @Test
  public void prependOnlyTable_prependsProperSql() {
    /* Given */
    AlterTableImpl table = new AlterTableImpl(null, "table", mock(SqlPart.class));
    RawSqlBuilder builder = new RawSqlBuilderImpl();

    /* When */
    table.prependTo(builder);

    /* Then */
    assertThat(builder.toString(), is("TABLE table"));
  }

  @Test
  public void prependDatabaseAndTable_prependsProperSql() {
    /* Given */
    AlterTableImpl table = new AlterTableImpl("database", "table", mock(SqlPart.class));
    RawSqlBuilder builder = new RawSqlBuilderImpl();

    /* When */
    table.prependTo(builder);

    /* Then */
    assertThat(builder.toString(), is("TABLE database.table"));
  }

  @Test
  public void previous_returnsProperItem() {
    /* Given */
    SqlPart sqlPart = mock(SqlPart.class);
    AlterTableImpl table = new AlterTableImpl("", "", sqlPart);

    /* When */
    SqlPart result = table.previous();

    /* Then */
    assertThat(result, is(sqlPart));
  }

  @Test
  public void renameTo_returnsNotNull() {
    /* Given */
    AlterTableImpl table = new AlterTableImpl("database", "table", mock(SqlPart.class));

    /* When */
    RenameTo result = table.renameTo("");

    /* Then */
    assertThat(result, is(notNullValue()));
  }

  @Test
  public void add_returnsNotNull() {
    /* Given */
    AlterTableImpl table = new AlterTableImpl("database", "table", mock(SqlPart.class));

    /* When */
    AddColumn result = table.add(mock(Column.class));

    /* Then */
    assertThat(result, is(notNullValue()));
  }

  @Test
  public void addColumn_returnsNotNull() {
    /* Given */
    AlterTableImpl table = new AlterTableImpl("database", "table", mock(SqlPart.class));

    /* When */
    AddColumn result = table.addColumn(mock(Column.class));

    /* Then */
    assertThat(result, is(notNullValue()));
  }
}