use ConsumerComplaints;

select * from Complaint;
describe Complaint;

select DateReceived, Product, Company, State
from Complaint;

select DateReceived, Product, Company, State
from Complaint
where State in ("LA", "TX");

SELECT *
FROM Complaint
WHERE State = 'LA'
AND (Product = 'Mortgage' OR Product = 'Debt collection');

SELECT *
FROM Complaint
WHERE State = 'LA'
AND Product = 'Mortgage' OR Product = 'Debt collection';

SELECT Product, Issue, Company, ResponseToConsumer
FROM Complaint
WHERE ConsumerDisputed = 1
AND ConsumerConsent = 1
AND Product NOT IN ("Mortage", "Debt collection");

SELECT *
FROM Complaint
WHERE SubProduct IS NULL;

SELECT * FROM Complaint WHERE SubProduct IS NOT NULL;

SELECT *
FROM Complaint
WHERE ComplaintId > 15000 OR ComplaintId IS NULL;

SELECT *
FROM Complaint
WHERE SubIssue = 'Account status'
OR SubIssue IS NULL;

-- All Complaints with a value for ComplaintNarrative. 
-- Exclude null values.
SELECT *
FROM Complaint
WHERE ComplaintNarrative IS NOT NULL;

SELECT 
	ComplaintId, 
	DateReceived, 
	DateSentToCompany, 
	DateDiff(DateSentToCompany, DateReceived) AS DateDifference
FROM Complaint;

SELECT 
	ComplaintId, 
	DateReceived, 
	DateSentToCompany, 
	DateDiff(DateSentToCompany, DateReceived) AS DateDifference
FROM Complaint
WHERE DateDiff(DateSentToCompany, DateReceived) > 100;