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

package com.nhaarman.sqlitebuilder.integration;

import org.junit.Test;

import static com.nhaarman.sqlitebuilder.impl.Statements.drop;

@SuppressWarnings("HardCodedStringLiteral")
public class DropTest extends IntegrationTestBase {

  @Test
  public void dropTable() {
    /* When */
    drop()
        .table("my_table")
        .executeOn(getStatementExecutor());

    /* Then */
    verifyStatementExecuted("DROP TABLE my_table");
  }

  @Test
  public void dropTableIfExists() {
    /* When */
    drop()
        .tableIfExists("my_database", "my_table")
        .executeOn(getStatementExecutor());

    /* Then */
    verifyStatementExecuted("DROP TABLE IF EXISTS my_database.my_table");
  }
}
