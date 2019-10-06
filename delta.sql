INSERT INTO public.investments (id, interest_rate, min_investment_month_time, name) VALUES ('765916a3-66ab-4f49-b022-68a56977c410', 5.40, 0, 'Nubank');
INSERT INTO public.investments (id, interest_rate, min_investment_month_time, name) VALUES ('52c0cf58-46e6-4ce6-ad75-938ccfa91d8a', 5.50, 24, 'LCI 100% CDI');


INSERT INTO public.interest (id, aliquot, final_month, start_month, investment_id) VALUES ('7da11dc2-c94c-453c-87c0-4b233c1a36f9', 22.50, 6, 0, '765916a3-66ab-4f49-b022-68a56977c410');
INSERT INTO public.interest (id, aliquot, final_month, start_month, investment_id) VALUES ('5826037f-3d20-4079-a3dd-325af038d5b0', 20.00, 12, 7, '765916a3-66ab-4f49-b022-68a56977c410');
INSERT INTO public.interest (id, aliquot, final_month, start_month, investment_id) VALUES ('a5211744-1138-4ccb-8e84-1503c4e0a331', 17.50, 24, 13, '765916a3-66ab-4f49-b022-68a56977c410');
INSERT INTO public.interest (id, aliquot, final_month, start_month, investment_id) VALUES ('acb0b4e1-159b-43c0-8e45-49fc2c14f95e', 15.00, 999, 25, '765916a3-66ab-4f49-b022-68a56977c410');
INSERT INTO public.interest (id, aliquot, final_month, start_month, investment_id) VALUES ('8f66df89-f6b5-4c24-9ddd-e1d841b58a16', 0.00, 999, 0, '52c0cf58-46e6-4ce6-ad75-938ccfa91d8a');
