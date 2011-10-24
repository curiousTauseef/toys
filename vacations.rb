#!/usr/local/bin/ruby

class Time
	@@holidays = [	Time.utc(2011,11,1).yday, 
					Time.utc(2011,12,6).yday, 
					Time.utc(2011,12,8).yday, 
					Time.utc(2011,12,24).yday, 
					Time.utc(2011,12,25).yday,
					Time.utc(2011,12,31).yday,
					Time.utc(2012,1,1).yday,
					Time.utc(2012,1,6).yday
	]
	def is_holiday?
		@@holidays.include? self.yday
	end
end

puts "Start date (YYYY/MM/DD): "
start_date = gets.split "/"
puts "End date (YYYY/MM/DD): "
end_date = gets.split "/"
start_date = Time.utc(start_date[0],start_date[1],start_date[2])
end_date = Time.utc(end_date[0],end_date[1],end_date[2])
one_day = 60*60*24
curr_day = start_date

work_days = 0
natural_days = 0

while curr_day <= end_date
	work_days += 1 unless curr_day.saturday? or curr_day.sunday? or curr_day.is_holiday?
	curr_day += one_day
	natural_days += 1
end
puts "Natural days: #{natural_days}"
puts "Work days: #{work_days}"
