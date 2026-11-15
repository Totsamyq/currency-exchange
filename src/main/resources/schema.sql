DROP TABLE IF EXISTS ExchangeRates;
DROP TABLE IF EXISTS Currencies;


CREATE TABLE Currencies(
                           ID INTEGER PRIMARY KEY AUTOINCREMENT,
                           Code Varchar UNIQUE NOT NULL,
                           FullName Varchar NOT NULL,
                           Sign Varchar NOT NULL,
                           CHECK(length(Code) = 3)
);
CREATE TABLE ExchangeRates(
                              ID INTEGER PRIMARY KEY AUTOINCREMENT,
                              BaseCurrencyId INTEGER NOT NULL,
                              TargetCurrencyId INTEGER NOT NULL,
                              Rate DECIMAL(6) NOT NULL,
                              FOREIGN KEY (BaseCurrencyId) REFERENCES Currencies (ID),
                              FOREIGN KEY  (TargetCurrencyId) REFERENCES Currencies (ID),
                              UNIQUE (BaseCurrencyId, TargetCurrencyId),
                              CHECK(Rate > 0),
                              CHECK(BaseCurrencyID != TargetCurrencyId)
    );


PRAGMA foreign_keys = ON;
INSERT INTO Currencies(Code, FullName, Sign) VALUES
                                                 ('EUR', 'Euro', '€'),
                                                 ('USD', 'United States dollar', '$'),
                                                 ('RUB', 'Russian Ruble', '₽');

INSERT INTO ExchangeRates(BaseCurrencyId,TargetCurrencyId,Rate) VALUES
                                                                    (2,1,0.9),
                                                                    (2,3, 82);
