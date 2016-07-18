package atividade.extra;

public enum SortingSelect {
	SELECTION {
		@Override
		public Sorting<Integer> getImplementation() {
			return new SelectionSort<>();
		}
	},
	INSERTION {
		@Override
		public Sorting<Integer> getImplementation() {
			return new InsertionSort<>();
		}
	}, QUICK  {
		@Override
		public Sorting<Integer> getImplementation() {
			return new QuickSort<>();
		}
	},MERGE {
		@Override
		public Sorting<Integer> getImplementation() {
			return new MergeSort<>();
		}
	};

	private SortingSelect() {
	}

	public abstract Sorting<Integer> getImplementation();
}