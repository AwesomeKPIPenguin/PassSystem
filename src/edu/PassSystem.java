package src.edu;

import java.time.LocalDateTime;

public class PassSystem {
	private LocalDateTime DayStart;
	private LocalDateTime DayEnd;

	public LocalDateTime getDayStart() {
		return DayStart;
	}

	public LocalDateTime getDayEnd() {
		return DayEnd;
	}

	private static Boolean isWorkingHours(LocalDateTime dayStart,
										  LocalDateTime dayEnd) {
		return (LocalDateTime.now().isAfter(dayStart) &&
				LocalDateTime.now().isBefore(dayEnd));
	}

	private static Boolean isRightDayOfWeek(SkiPass.Types type) {
		if (type == SkiPass.Types.Weekday)
			return (LocalDateTime.now().getDayOfWeek().ordinal() < 5);
		else
			return (LocalDateTime.now().getDayOfWeek().ordinal() > 4);
	}

	public Boolean pass(SkiPass skiPass) {
		switch (skiPass.Type) {
			case Season:
				return (isWorkingHours(DayStart, DayEnd));

			case Weekday:
			case Weekend:
				if (!isWorkingHours(DayStart, DayEnd) ||
						!isRightDayOfWeek(skiPass.Type))
					return (false);
				if (skiPass.getDateTill() != null)
					return (LocalDateTime.now().isBefore(skiPass.getDateTill()));
				else if (skiPass.getRides() > 0) {
					skiPass.decRides();
					return (true);
				}
				else
					return (false);
		}
		return (false);
	}
}
