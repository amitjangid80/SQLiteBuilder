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

import com.nhaarman.sqlitebuilder.RawSqlBuilder;
import com.nhaarman.sqlitebuilder.SqlPart;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@SuppressWarnings("HardCodedStringLiteral")
public class UpdateSelectWhereImplTest {

  @Test
  public void prependTo_prependsProperSql() {
    /* Given */
    UpdateWhereImpl updateWhere = new UpdateWhereImpl("a=?", new Object[] {1}, mock(SqlPart.class));
    RawSqlBuilder builder = new RawSqlBuilderImpl();

    /* When */
    updateWhere.prependTo(builder);

    /* Then */
    assertThat(builder.toString(), is("WHERE a=?"));
  }

  @Test
  public void getArguments_returnsProperArguments() {
    /* Given */
    UpdateWhereImpl updateWhere = new UpdateWhereImpl("a=?", new Object[] {1}, mock(SqlPart.class));

    /* When */
    Object[] arguments = updateWhere.getArguments();

    /* Then */
    assertThat(arguments, is(arrayContaining((Object) 1)));
  }

  @Test
  public void previous_returnsProperItem() {
    /* Given */
    SqlPart sqlPart = mock(SqlPart.class);
    UpdateWhereImpl updateWhere = new UpdateWhereImpl("a=?", new Object[] {1}, sqlPart);

    /* When */
    SqlPart result = updateWhere.previous();

    /* Then */
    assertThat(result, is(sqlPart));
  }
}