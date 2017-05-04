## Update 1
 DELIMITER $$
 
 CREATE PROCEDURE FindFreeBookBySKU(IN mSKU CHAR(13), OUT m_ID INT   )
 BEGIN
	SELECT ID
    INTO m_ID
    FROM cuon_sach
    WHERE SKU = mSKU AND mStatus = 0
    LIMIT 1;
END$$