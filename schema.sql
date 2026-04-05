CREATE DATABASE IF NOT EXISTS fuel_calculator_localization
    CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE fuel_calculator_localization;

CREATE TABLE IF NOT EXISTS calculation_records (
    id           INT AUTO_INCREMENT PRIMARY KEY,
    distance     DOUBLE       NOT NULL,
    consumption  DOUBLE       NOT NULL,
    price        DOUBLE       NOT NULL,
    total_fuel   DOUBLE       NOT NULL,
    total_cost   DOUBLE       NOT NULL,
    language     VARCHAR(10),
    created_at   TIMESTAMP    DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS localization_strings (
    id       INT AUTO_INCREMENT PRIMARY KEY,
    `key`    VARCHAR(100) NOT NULL,
    value    VARCHAR(255) NOT NULL,
    language VARCHAR(10)  NOT NULL,
    UNIQUE KEY unique_key_lang (`key`, `language`)
);

INSERT IGNORE INTO localization_strings (`key`, value, language) VALUES
('distance.label',    'Distance (km):',                  'en'),
('consumption.label', 'Fuel Consumption (L/100 km):',    'en'),
('price.label',       'Fuel Price (per liter):',         'en'),
('calculate.button',  'Calculate Trip Cost',             'en'),
('result.label',      'Total fuel needed: {0} L | Total cost: {1}', 'en'),
('invalid.input',     'Invalid input. Please enter valid numbers.', 'en');

INSERT IGNORE INTO localization_strings (`key`, value, language) VALUES
('distance.label',    'Distance (km) :',                          'fr'),
('consumption.label', 'Consommation de carburant (L/100 km) :',   'fr'),
('price.label',       'Prix du carburant (par litre) :',          'fr'),
('calculate.button',  'Calculer le coût du trajet',               'fr'),
('result.label',      'Carburant total nécessaire : {0} L | Coût total : {1}', 'fr'),
('invalid.input',     'Entrée invalide. Veuillez entrer des nombres valides.', 'fr');

INSERT IGNORE INTO localization_strings (`key`, value, language) VALUES
('distance.label',    '距離（km）：',                    'ja'),
('consumption.label', '燃料消費量（L/100 km）：',         'ja'),
('price.label',       '燃料価格（1リットル当たり）：',    'ja'),
('calculate.button',  '走行コストを計算する',             'ja'),
('result.label',      '必要燃料量: {0} L | 合計コスト: {1}',         'ja'),
('invalid.input',     '入力が無効です。有効な数値を入力してください。', 'ja');

INSERT IGNORE INTO localization_strings (`key`, value, language) VALUES
('distance.label',    'مسافت (کیلومتر):',                          'fa'),
('consumption.label', 'مصرف سوخت (لیتر/100 کیلومتر):',            'fa'),
('price.label',       'قیمت سوخت (به ازای هر لیتر):',             'fa'),
('calculate.button',  'محاسبه هزینه سفر',                          'fa'),
('result.label',      'سوخت مورد نیاز: {0} لیتر | هزینه کل: {1}', 'fa'),
('invalid.input',     'ورودی نامعتبر. لطفاً اعداد معتبر وارد کنید.', 'fa');
