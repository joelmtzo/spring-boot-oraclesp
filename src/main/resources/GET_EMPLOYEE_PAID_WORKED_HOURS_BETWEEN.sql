CREATE OR REPLACE PROCEDURE GET_EMPLOYEE_PAID_WORKED_HOURS_BETWEEN(employee_id IN NUMBER, start_date IN VARCHAR, end_date IN VARCHAR, paid_hours OUT NUMBER)
AS
	JOB_ID NUMBER;
	SALARY NUMBER;
BEGIN

	SELECT JOB_ID INTO JOB_ID
	FROM EMPLOYEES
	WHERE ID = EMPLOYEE_ID;

	SELECT SALARY INTO SALARY
	FROM JOBS
	WHERE ID = JOB_ID;

	SELECT SUM(WORKED_HOURS) * SALARY INTO paid_hours
	FROM EMPLOYEE_WORKED_HOURS C
	WHERE C.EMPLOYEE_ID = EMPLOYEE_ID
	AND C.WORKED_DATE BETWEEN TO_DATE(START_DATE, 'yyyy-MM-dd')
	AND TO_DATE(END_DATE, 'yyyy-MM-dd');

END;