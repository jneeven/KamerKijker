from dataclasses import dataclass, field
from typing import Dict


@dataclass
class StockItem:
    """Represents a stock and its financial data."""

    name: str
    symbol: str
    description: str
    sic: str  # Code and description of industry

    # To be filled after initialization
    income: Dict = field(default_factory=dict, init=False)
    balance: Dict = field(default_factory=dict, init=False)
    cash_flow: Dict = field(default_factory=dict, init=False)
