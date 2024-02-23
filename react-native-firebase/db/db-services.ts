import {enablePromise, openDatabase, SQLiteDatabase} from 'react-native-sqlite-storage';
import {GameProps} from '../Game';

const tableName = 'savedGames';

enablePromise(true);

export const getDBConnection = async () => {
  return openDatabase({name: 'saved-games.db', location: 'default'});
};

export const createTable = async (db: SQLiteDatabase) => {
  // create table if not exists
  const query = `CREATE TABLE IF NOT EXISTS ${tableName}(
        NAME varchar(255) PRIMARY KEY,
        TYPE INTEGER,
        SCORE INTEGER,
        DATE DATE
    );`;

  await db.executeSql(query);
};

export const getSavedGames = async (db: SQLiteDatabase): Promise<GameProps[]> => {
    try {
        const items: GameProps[] = [];
        const results = await db.executeSql(`SELECT * FROM ${tableName}`);
        results.forEach(result => {
            for (let i = 0; i < result.rows.length; i++) {
                items.push(result.rows.item(i));
            }
        });
        return items;
    }catch(e){
        console.log(e);
        throw Error('Error getting saved games');
    }
}

export const saveGame = async (db: SQLiteDatabase, gamefile: GameProps) => {
    const query = `INSERT OR REPLACE INTO ${tableName} (NAME, TYPE, SCORE, DATE) VALUES (?, ?, ?, ?)`;
  
    return db.executeSql(query, [gamefile.name, gamefile.type, gamefile.score, gamefile.date]);
}

export const deleteGame = async (db: SQLiteDatabase, name: string) => {
  const deleteQuery = `DELETE from ${tableName} where NAME = ${name}`;
  await db.executeSql(deleteQuery);
};

export const deleteTable = async (db: SQLiteDatabase) => {
  const query = `drop table ${tableName}`;

  await db.executeSql(query);
};


