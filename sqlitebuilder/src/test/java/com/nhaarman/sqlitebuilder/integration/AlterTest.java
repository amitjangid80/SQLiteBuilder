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

import static com.nhaarman.sqlitebuilder.impl.Statements.alter;
import static com.nhaarman.sqlitebuilder.impl.Statements.column;

@SuppressWarnings("HardCodedStringLiteral")
public class AlterTest extends IntegrationTestBase {

  @Test
  public void alterRenameTo() {
    /* When */
    alter()
        .table("database", "table")
        .renameTo("newTableName")
        .executeOn(getStatementExecutor());

    /* Then */
    verifyStatementExecuted("ALTER TABLE database.table RENAME TO newTableName");
  }

  @Test
  public void alterAddColumn() {
    /* When */
    alter()
        .table("database", "table")
        .add(
            column("new_column").integer()
        )
        .executeOn(getStatementExecutor());

    /* Then */
    verifyStatementExecuted("ALTER TABLE database.table ADD COLUMN new_column INTEGER");
  }
}
